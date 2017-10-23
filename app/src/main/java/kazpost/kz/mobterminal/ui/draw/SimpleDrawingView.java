package kazpost.kz.mobterminal.ui.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SimpleDrawingView extends View implements RotationGestureDetector.OnRotationGestureListener {

    private Path path = new Path();
    private RotationGestureDetector mRotationDetector;

    // setup initial color
    private final int paintColor = Color.BLACK;
    // defines paint and canvas
    private Paint drawPaint;
    // Store circles to draw each time the user touches down
    private List<Point> circlePoints;


    public SimpleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPaint(); // same as before
        circlePoints = new ArrayList<>();
        mRotationDetector = new RotationGestureDetector(this);
    }

    // Get x and y and append them to the path
    public boolean onTouchEvent(MotionEvent event) {
        mRotationDetector.onTouchEvent(event);

       /* float pointX = event.getX();
        float pointY = event.getY();
        // Checks for the event that occurs
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Starts a new line in the path
                path.moveTo(pointX, pointY);
                break;
            case MotionEvent.ACTION_MOVE:
                // Draws line between last point and this point
                path.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }
*/
//        postInvalidate(); // Indicate view should be redrawn
        return true; // Indicate we've consumed the touch
    }

    // Draw each circle onto the view
    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawPath(path, drawPaint);
        canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 20, drawPaint);
        drawPaint.setColor(Color.GREEN);
        canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2 -150, 20, drawPaint);
        drawPaint.setColor(Color.BLUE);
        canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2 -250, 20, drawPaint);
    }

    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

    }

    @Override
    public void OnRotation(RotationGestureDetector rotationDetector) {
        float angle = rotationDetector.getAngle();
        this.setRotation(angle);
        Log.d("RotationGestureDetector", "Rotation: " + Float.toString(angle));

    }
}