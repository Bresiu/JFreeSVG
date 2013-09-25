package org.jfree.graphics2d.svg;

/**
 * @author Nicolas Fortin
 */
public interface AppendableWithoutException {

    /**
     * @param str String to append
     * @return this
     */
    AppendableWithoutException append(String str);

    /**
     * @param str Integer to append
     * @return this
     */
    AppendableWithoutException append(int integer);
}
