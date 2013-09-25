package org.jfree.graphics2d.svg;

/**
 * @author Nicolas Fortin
 */
public class AppendableStringBuilder implements AppendableWithoutException {
    private StringBuilder stringBuilder;

    public AppendableStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public AppendableWithoutException append(String str) {
        stringBuilder.append(str);
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    @Override
    public AppendableWithoutException append(int integer) {
        return append(String.valueOf(integer));
    }
}
