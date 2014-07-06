package net.ptnkjke.utils;

import org.apache.bcel.Constants;
import org.apache.bcel.generic.Instruction;
import org.apache.bcel.generic.InstructionHandle;

/**
 * Created by Lopatin on 06.07.2014.
 */
public class Editor extends InstructionHandleWorker {
    private String result;

    private void base(InstructionHandle handle) {
        result = Constants.OPCODE_NAMES[handle.getInstruction().getOpcode()] + "      // " + handle.toString();
    }

    private void select(InstructionHandle handle) {

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public void visitDADD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDDIV(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDMUL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDNEG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDREM(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDSUB(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFADD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFDIV(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFMUL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFNEG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFREM(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFSUB(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIADD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIAND(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIDIV(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIMUL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitINEG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIOR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIREM(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitISHL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitISHR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitISUB(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIUSHR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIXOR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLADD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLAND(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLDIV(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLMUL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLNEG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLOR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLREM(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLSHL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLSHR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLSUB(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLUSHR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLXOR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitAALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitAASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitBALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitBASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitCALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitCASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitSALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitSASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitGOTO(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitGOTO_W(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIF_ACMPEQ(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIF_ACMPNE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIF_ICMPEQ(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIF_ICMPGT(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIF_ICMPGE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIF_ICMPLE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIF_ICMPLT(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIF_ICMPNE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIFEQ(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIFGE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIFGT(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIFLE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIFLT(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIFNE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIFNONNULL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIFNULL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitJSR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitJSR_W(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLOOKUPSWITCH(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitTABLESWITCH(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitD2F(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitD2I(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitD2L(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitF2D(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitF2I(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitF2L(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2B(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2C(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2D(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2F(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2L(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2S(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitL2D(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitL2F(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitL2I(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitANEWARRAY(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitCHECKCAST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitINSTANCEOF(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLDC(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLDC2_W(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitMULTIANEWARRAY(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitGETFIELD(InstructionHandle handle) {
        base(handle);
    }

    @Override
    public void visitGETSTATIC(InstructionHandle handle) {
        base(handle);
    }

    @Override
    public void visitINVOKEINTERFACE(InstructionHandle handle) {
        base(handle);
    }

    @Override
    public void visitINVOKESPECIAL(InstructionHandle handle) {
        base(handle);
    }

    @Override
    public void visitINVOKESTATIC(InstructionHandle handle) {
        base(handle);
    }

    @Override
    public void visitINVOKEVIRTUAL(InstructionHandle handle) {
        base(handle);
    }

    @Override
    public void visitPUTFIELD(InstructionHandle handle) {
        base(handle);
    }

    @Override
    public void visitPUTSTATIC(InstructionHandle handle) {
        base(handle);
    }

    @Override
    public void visitINVOKEDYNAMIC(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitNEW(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDLOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFLOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLLOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitILOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDSTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFSTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitISTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLSTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIINC(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitARETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP_X1(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP_X2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP2_X1(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP2_X2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitPOP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitPOP2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitSWAP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitACONST_NULL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitARRAYLENGTH(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitATHROW(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitBREAKPOINT(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDCMPG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDCONST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFCMPG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFCMPL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFCONST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitICONST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIMPDEP1(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIMPDEP2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLCMP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLCONST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitMONITORENTER(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitMONITOREXIT(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitNEWARRAY(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitNOP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitRET(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitSIPUSH(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitBIPUSH(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }
}
