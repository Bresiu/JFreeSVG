package org.jfree.graphics2d.svg;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Nicolas Fortin
 */
public class AppendableOutputStream implements AppendableWithoutException {
    private OutputStream outputStream;

    public AppendableOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public AppendableOutputStream append(String str) {
        try {
            outputStream.write(str.getBytes());
        } catch (IOException ex) {
            throw new IllegalStateException(ex.getLocalizedMessage(), ex);
        }
        return this;
    }

    @Override
    public AppendableWithoutException append(int integer) {
        return append(String.valueOf(integer));
    }
}
