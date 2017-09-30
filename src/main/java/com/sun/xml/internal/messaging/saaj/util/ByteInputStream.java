//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.sun.xml.internal.messaging.saaj.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteInputStream extends ByteArrayInputStream {
    private static final byte[] EMPTY_ARRAY = new byte[0];

    public ByteInputStream() {
        this(EMPTY_ARRAY, 0);
    }

    public ByteInputStream(byte[] buf, int length) {
        super(buf, 0, length);
    }

    public ByteInputStream(byte[] buf, int offset, int length) {
        super(buf, offset, length);
    }

    public byte[] getBytes() {
        return this.buf;
    }

    public int getCount() {
        return this.count;
    }

    public void close() throws IOException {
        this.reset();
    }

    public void setBuf(byte[] buf) {
        this.buf = buf;
        this.pos = 0;
        this.count = buf.length;
    }
}
