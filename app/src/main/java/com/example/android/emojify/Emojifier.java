package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {
    private static final String TAG = "EMOJIFIERFACES";

    public static void detectFaces(Context context, Bitmap image) {
        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(image).build();

        // Create the face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Detect the faces
        SparseArray<Face> faces = detector.detect(frame);

        // Log the number of faces
        Log.d(TAG, "detectFaces: number of faces = " + faces.size());

        if (faces.size() == 0) {
            Toast.makeText(context, "No faces detected!", Toast.LENGTH_SHORT).show();
        }

        // Release the detector
        detector.release();
    }
}
