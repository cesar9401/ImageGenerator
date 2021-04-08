package com.cesar31.imggenerator.control;

import com.cesar31.imggenerator.parser.ImageLex;
import com.cesar31.imggenerator.parser.ImageParser;
import com.cesar31.imggenerator.structures.MatrixNode;
import java.io.StringReader;
import java.util.List;

/**
 *
 * @author cesar31
 */
public class ParserController {

    public Object parserFile(String input) {
        Object object = null;
        ImageLex lex = new ImageLex(new StringReader(input));
        ImageParser parser = new ImageParser(lex, this);
        try {
            object = parser.parse().value;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        
        return object;
    }

    /**
     * Crear nodos para la matriz
     *
     * @param cells
     * @param color
     * @return
     */
    public MatrixNode getMatrixNode(List<Integer> cells, String color) {
        MatrixNode node = null;
        if (cells.size() == 2) {
            node = new MatrixNode(cells.get(0), cells.get(1), color);
        } else {
            /* Error */
        }

        return node;
    }
}
