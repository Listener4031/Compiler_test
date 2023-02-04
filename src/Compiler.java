import AST.RootNode;
import Assembly.AssemblyGlobalDefine;
import Backend.AssemblyBuilder;
import Backend.AssemblyPrinter;
import Backend.IRBuilder;
import Backend.IRPrinter;
import Frontend.ASTBuilder;
import Frontend.SymbolCollector;
import MIR.globalDefine;
import Optimize.AggressiveDCE;
import Optimize.ConstantPropagation;
import Optimize.InlineExpansion;
import Optimize.MemToReg;
import Optimize.RegisterAllocation;
import Optimize.SimpleDCE;
import Frontend.SemanticChecker;
import Parser.MxLiteLexer;
import Parser.MxLiteParser;
import Util.*;
import Util.error.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Compiler {
    public static void main(String[] args) throws Exception{
        String name = "test.mx";
        InputStream raw = new FileInputStream(name);
        PrintStream out = new PrintStream("output.s");
        try {
            CharStream input = CharStreams.fromStream(raw);
            MxLiteLexer lexer = new MxLiteLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxLiteErrorListener());
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MxLiteParser parser = new MxLiteParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(new MxLiteErrorListener());
            ParseTree parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder();
            RootNode ASTRoot = (RootNode) astBuilder.visit(parseTreeRoot);
            globalScope gScope = new globalScope();
            new SymbolCollector(gScope).visit(ASTRoot);
            new SemanticChecker(gScope).visit(ASTRoot);
            globalDefine globalDef = new globalDefine();
            new IRBuilder(globalDef, gScope).visit(ASTRoot);
            new MemToReg(globalDef);
            new ConstantPropagation(globalDef);
            new AggressiveDCE(globalDef).DCE();
            new InlineExpansion (globalDef);
            AssemblyGlobalDefine assemblyGlobalDefine = new AssemblyGlobalDefine();
            new AssemblyBuilder(globalDef, assemblyGlobalDefine);
            new RegisterAllocation(assemblyGlobalDefine);
            new AssemblyPrinter(out, assemblyGlobalDefine);
        } 
        catch(error er){
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}