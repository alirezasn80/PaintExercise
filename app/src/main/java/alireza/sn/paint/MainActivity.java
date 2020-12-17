package alireza.sn.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static alireza.sn.paint.PaintView.currentBrush;
import static alireza.sn.paint.PaintView.colorList;
import static alireza.sn.paint.PaintView.pathList;

public class MainActivity extends AppCompatActivity {
    public static Paint paintBrush = new Paint();
    public static Path path = new Path();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void brushClick(View view) {
        paintBrush.setColor(Color.BLACK);
        currentColor(paintBrush.getColor());
    }

    public void eraserClick(View view) {
        pathList.clear();
        colorList.clear();
        path.reset();
    }

    public void redClick(View view) {
        paintBrush.setColor(Color.RED);
        currentColor(paintBrush.getColor());
    }

    public void currentColor(int color){
        currentBrush = color;
        path = new Path();
        Log.i("TAG","new path");
    }
}