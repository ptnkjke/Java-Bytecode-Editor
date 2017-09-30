package net.ptnkjke.jbeditor.logic.own.bytecode;


public class Constants {
    /** Marks a constant pool entry as type UTF-8.  */
    public final static byte CONSTANT_Utf8               = 1;

    /** Marks a constant pool entry as type Integer.  */
    public final static byte CONSTANT_Integer            = 3;

    /** Marks a constant pool entry as type Float.  */
    public final static byte CONSTANT_Float              = 4;

    /** Marks a constant pool entry as type Long.  */
    public final static byte CONSTANT_Long               = 5;

    /** Marks a constant pool entry as type Double.  */
    public final static byte CONSTANT_Double             = 6;

    /** Marks a constant pool entry as a Class.  */
    public final static byte CONSTANT_Class              = 7;

    /** Marks a constant pool entry as a Field Reference.  */
    public final static byte CONSTANT_Fieldref           = 9;

    /** Marks a constant pool entry as type String.  */
    public final static byte CONSTANT_String             = 8;

    /** Marks a constant pool entry as a Method Reference.  */
    public final static byte CONSTANT_Methodref          = 10;

    /** Marks a constant pool entry as an Interface Method Reference.  */
    public final static byte CONSTANT_InterfaceMethodref = 11;

    /** Marks a constant pool entry as a name and type.  */
    public final static byte CONSTANT_NameAndType        = 12;

    /** Marks a constant pool entry as a Method Handle.  */
    public static final byte CONSTANT_MethodHandle       = 15;

    /** Marks a constant pool entry as a Method Type.    */
    public static final byte CONSTANT_MethodType         = 16;

    /** Marks a constant pool entry as an Invoke Dynamic */
    public static final byte CONSTANT_InvokeDynamic      = 18;
}
