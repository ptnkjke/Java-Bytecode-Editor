package net.ptnkjke.utils;

import net.ptnkjke.Configutation;
import net.ptnkjke.gui.main.model.ConsoleMessage;
import net.ptnkjke.gui.main.model.MessageType;
import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.generic.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Lopatin on 05.07.2014.
 */
public class GraphVizCreator extends InstructionHandleWorker {

    private int lastCounter = 0;
    StringBuilder sb = new StringBuilder();
    InstructionList list;
    ConstantPoolGen cpg;

    public GraphVizCreator(InstructionList list, ConstantPoolGen cpg) {
        this.list = list;
        this.cpg = cpg;
    }

    private void visitBase(InstructionHandle instructionHandle) {
        InstructionHandle nextHandle = instructionHandle.getNext();

        sb.append(String.format("%d[label=\"%s\"];\n", instructionHandle.getPosition(), instructionHandle.toString()));
        if (nextHandle != null) {
            sb.append(String.format("%d -> %d[label=\"next\", color=\"#839096\"];\n", instructionHandle.getPosition(), nextHandle.getPosition()));
        } else {
            System.out.println("next == null");
        }
    }

    private void visitBranchInstruction(InstructionHandle instructionHandle) {
        InstructionHandle nextHandle = instructionHandle.getNext();
        Instruction instruction = instructionHandle.getInstruction();
        BranchInstruction branchInstruction = (BranchInstruction) instruction;
        InstructionHandle target = branchInstruction.getTarget();

        sb.append(String.format("%d[shape=diamond,label=\"%s\"];\n", instructionHandle.getPosition(), instructionHandle.toString()));
        if (nextHandle != null) {
            sb.append(String.format("%d -> %d[label=\"next\", color=\"#839096\"];\n", instructionHandle.getPosition(), nextHandle.getPosition()));
        }

        if (target != null) {
            sb.append(String.format("%d -> %d[label=\"target\"];\n", instructionHandle.getPosition(), target.getPosition()));
        }
    }

    private void visitSelect(InstructionHandle instructionHandle) {
        InstructionHandle nextHandle = instructionHandle.getNext();

        Select select = (Select) instructionHandle.getInstruction();

        InstructionHandle[] targets = select.getTargets();

        sb.append(String.format("%d[label=\"%s\"];\n", instructionHandle.getPosition(), instructionHandle.toString()));

        if (nextHandle != null) {
            sb.append(String.format("%d -> %d[label=\"next\", color=\"#839096\"];\n", instructionHandle.getPosition(), nextHandle.getPosition()));
        }

        InstructionHandle target = select.getTarget();
        if (target != null) {
            sb.append(String.format("%d -> %d [label=\"default\"];\n", instructionHandle.getPosition(), target.getPosition()));
        }

        int i = 0;
        for (InstructionHandle h : targets) {
            sb.append(String.format("%d -> %d [label=\"match%d\"];\n", instructionHandle.getPosition(), h.getPosition(), i));
            i++;
        }
    }

    public String getText() {
        return sb.toString();
    }

    public void visitAll() {
        lastCounter = 0;
        sb = new StringBuilder();
        visit(list.getStart());
    }


    public File getImage() {
        visitAll();

        File workDir = new File(Configutation.workDir);
        if (!workDir.exists()) {
            workDir.mkdirs();
        }
        String nameRandom = Utils.getRandomName();
        File temp = new File(workDir, nameRandom + ".txt");

        String path = Configutation.workDir + File.separator + nameRandom + ".txt";
        String out = Configutation.workDir + File.separator + nameRandom + ".svg";

        File outFile = new File(out);
        File inFile = new File(path);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));

            writer.write(sb.toString());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (outFile.exists()) {
            System.out.println("exists");
            if (outFile.delete()) {
                System.out.println("deleted");
            }
        }
        if (!new File(Configutation.graphVizPath).exists()) {
            return null;
        }
        String command = String.format("%s -Tsvg -o%s %s", Configutation.graphVizPath, outFile.getAbsolutePath(), inFile.getAbsolutePath());

        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        int counter = 0;
        while (!outFile.canWrite() && !outFile.exists() && counter != 2000) {
            try {
                System.out.println("i waiting");
                Thread.sleep(100);
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return outFile;
    }

    @Override
    public void visit(InstructionHandle handle) {
        sb.append("digraph g{");
        sb.append("node [fontsize=8, shape = box];\nedge [fontsize=8]");
        do {
            try {
                super.visit(handle);
            } catch (Exception e) {
                ConsoleMessage consoleMessage = new ConsoleMessage(e.getClass().getName() + " " + e.getMessage(), MessageType.CRITICAL);
                e.printStackTrace();
            }
            handle = handle.getNext();
        }
        while (handle != null);
        sb.append("}");
    }

    @Override
    public void visitDADD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDDIV(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDMUL(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDNEG(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDREM(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDSUB(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFADD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFDIV(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFMUL(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFNEG(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFREM(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFSUB(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIADD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIAND(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIDIV(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIMUL(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitINEG(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIOR(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIREM(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitISHL(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitISHR(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitISUB(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIUSHR(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIXOR(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLADD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLAND(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLDIV(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLMUL(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLNEG(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLOR(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLREM(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLSHL(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLSHR(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLSUB(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLUSHR(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLXOR(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitAALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitAASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitBALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitBASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitCALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitCASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitSALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitSASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitGOTO(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitGOTO_W(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIF_ACMPEQ(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIF_ACMPNE(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIF_ICMPEQ(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIF_ICMPGT(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIF_ICMPGE(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIF_ICMPLE(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIF_ICMPLT(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIF_ICMPNE(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIFEQ(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIFGE(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIFGT(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIFLE(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIFLT(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIFNE(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIFNONNULL(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitIFNULL(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitJSR(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitJSR_W(InstructionHandle instructionHandle) {
        visitBranchInstruction(instructionHandle);
    }

    @Override
    public void visitLOOKUPSWITCH(InstructionHandle instructionHandle) {
        visitSelect(instructionHandle);
    }

    @Override
    public void visitTABLESWITCH(InstructionHandle instructionHandle) {
        visitSelect(instructionHandle);
    }

    @Override
    public void visitD2F(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitD2I(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitD2L(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitF2D(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitF2I(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitF2L(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitI2B(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitI2C(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitI2D(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitI2F(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitI2L(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitI2S(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitL2D(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitL2F(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitL2I(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitANEWARRAY(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitCHECKCAST(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitINSTANCEOF(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLDC(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLDC2_W(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitMULTIANEWARRAY(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitGETFIELD(InstructionHandle handle) {
        visitBase(handle);
    }

    @Override
    public void visitGETSTATIC(InstructionHandle handle) {
        CPInstruction cpInstruction = (CPInstruction) handle.getInstruction();
        Constant constant = cpg.getConstant(cpInstruction.getIndex());

        InstructionHandle nextHandle = handle.getNext();


        String text = handle.toString() + constant.toString();
        sb.append(String.format("%d[label=\"%s\"];\n", handle.getPosition(), text));
        if (nextHandle != null) {
            sb.append(String.format("%d -> %d[label=\"next\"];\n", handle.getPosition(), nextHandle.getPosition()));
        } else {
            System.out.println("next == null");
        }


    }

    @Override
    public void visitINVOKEINTERFACE(InstructionHandle handle) {
        visitBase(handle);
    }

    @Override
    public void visitINVOKESPECIAL(InstructionHandle handle) {
        visitBase(handle);
    }

    @Override
    public void visitINVOKESTATIC(InstructionHandle handle) {
        visitBase(handle);
    }

    @Override
    public void visitINVOKEVIRTUAL(InstructionHandle handle) {
        visitBase(handle);
    }

    @Override
    public void visitPUTFIELD(InstructionHandle handle) {
        visitBase(handle);
    }

    @Override
    public void visitPUTSTATIC(InstructionHandle handle) {
        visitBase(handle);
    }

    @Override
    public void visitINVOKEDYNAMIC(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitNEW(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitALOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDLOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFLOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLLOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitILOAD(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitASTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDSTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFSTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitISTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLSTORE(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIINC(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitARETURN(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDRETURN(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFRETURN(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIRETURN(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLRETURN(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitRETURN(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDUP(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDUP2(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDUP_X1(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDUP_X2(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDUP2_X1(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDUP2_X2(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitPOP(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitPOP2(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitSWAP(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitACONST_NULL(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitARRAYLENGTH(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitATHROW(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitBREAKPOINT(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDCMPG(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitDCONST(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFCMPG(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFCMPL(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitFCONST(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitICONST(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIMPDEP1(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitIMPDEP2(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLCMP(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitLCONST(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitMONITORENTER(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitMONITOREXIT(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitNEWARRAY(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitNOP(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitRET(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitSIPUSH(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }

    @Override
    public void visitBIPUSH(InstructionHandle instructionHandle) {
        visitBase(instructionHandle);
    }
}


