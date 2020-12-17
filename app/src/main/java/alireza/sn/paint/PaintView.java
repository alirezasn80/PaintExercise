package alireza.sn.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static alireza.sn.paint.MainActivity.paintBrush;
import static alireza.sn.paint.MainActivity.path;

public class PaintView extends View {
    public static ArrayList<Integer> colorList = new ArrayList<>();
    public static ArrayList<Path> pathList = new ArrayList<>();
    public ViewGroup.LayoutParams params;
    public static int currentBrush = Color.BLACK;

    public PaintView(Context context) {
        super(context);
        init();
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paintBrush.setAntiAlias(true);
        paintBrush.setColor(Color.BLACK);
        paintBrush.setStyle(Paint.Style.STROKE);
        paintBrush.setStrokeWidth(10f);
        paintBrush.setStrokeCap(Paint.Cap.ROUND);
        paintBrush.setStrokeJoin(Paint.Join.ROUND);
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void onDraw(Canvas canvas) {

//        for (int i=0; i<pathList.size();i++){
//            paintBrush.setColor(colorList.get(i));
//            canvas.drawPath(pathList.get(i),paintBrush);
//            invalidate();
//        }

        canvas.drawPath(path,paintBrush);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
               // pathList.add(path);
               // colorList.add(currentBrush);
                break;

            default:
                return false;
        }

        postInvalidate();
        return false;
    }
}
