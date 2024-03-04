package edu.mit.simile.vicino.distances;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

public class BZip2Distance extends PseudoMetricDistance {

    public double d2(String x, String y) {
        String str = x + y;
        double result = 0.0f;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(str.length());
             BZip2CompressorOutputStream os = new BZip2CompressorOutputStream(baos)) {
            os.write(str.getBytes());
            result = baos.toByteArray().length;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
