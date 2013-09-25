/* ===================================================
 * JFreeSVG : an SVG library for the Java(tm) platform
 * ===================================================
 * 
 * (C)opyright 2013, by Object Refinery Limited.  All rights reserved.
 *
 * Project Info:  http://www.jfree.org/jfreesvg/index.html
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 * 
 */

package org.jfree.graphics2d.svg;

import org.junit.Test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 * A basic test class for writing to a BufferedImage via Graphics2D.  This is
 * used as a reference implementation.
 */
public class SVGGraphics2DTest {
    
    /**
     * Starting point for the demo.
     * 
     * @param args  ignored.
     * 
     * @throws IOException 
     */
    @Test
    public void testGraphics2D() throws IOException {
        SVGGraphics2D g2 = new SVGGraphics2D(600, 400);
        ImageIcon icon = new ImageIcon(SVGGraphics2DTest.class.getResource("jfree_chart_1.jpg"));
        g2.rotate(Math.PI / 12);
        g2.setStroke(new BasicStroke(2.0f));
        g2.setPaint(Color.WHITE);
        g2.fill(new Rectangle(0, 0, 600, 400));
        g2.setPaint(Color.RED);
        g2.draw(new Rectangle(0, 0, 600, 400));
        g2.drawImage(icon.getImage(), 10, 20, null);
        FileOutputStream fileOutputStream = new FileOutputStream(new File("target/testGraphics2D.svg"));
        try {
            fileOutputStream.write(g2.getSVGDocument().getBytes());
        } finally {
            fileOutputStream.close();
        }
    }
}
