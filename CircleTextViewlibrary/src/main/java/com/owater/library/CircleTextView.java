package com.owater.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Owater on 2015/7/23.
 */
public class CircleTextView extends TextView {

	private static final int DEFAULT_FILL_TYPE = 0;
	
	private float mRadius;
	private int backgroundColor;
	private int borderColor;
	private float borderWidth;
	private float borderAlpha;
	private int ctType;

	private float mCornerRadius = 360;
	private float mDx = 0;
	private float mDy = 0;
	
	public CircleTextView(Context context) {
		super(context);
	}

	public CircleTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}
	
	private void init(Context context, AttributeSet attrs) {
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.circleTextView);
		backgroundColor = typedArray.getColor(R.styleable.circleTextView_ct_backgroundColor, Color.WHITE);
		borderColor = typedArray.getColor(R.styleable.circleTextView_ct_border_color, Color.TRANSPARENT);
		borderWidth = typedArray.getDimension(R.styleable.circleTextView_ct_border_width, 0);
		borderAlpha = typedArray.getFloat(R.styleable.circleTextView_ct_border_alpha, 1);
		ctType = typedArray.getInt(R.styleable.circleTextView_ct_type, DEFAULT_FILL_TYPE);
		typedArray.recycle();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		mRadius = Math.min(getHeight(), getWidth()) / 2;

		if (ctType == 1){
			setBackgroundCompat(getWidth(),getHeight());
		}else if(ctType == 2){
			paint.setColor(borderColor);
			paint.setAntiAlias(true);
			paint.setAlpha((int) (255 * borderAlpha));
			canvas.drawCircle(getWidth() / 2, getHeight() / 2, mRadius, paint);
		}else {
			borderWidth = 0;
		}

		paint.setColor(backgroundColor);
		paint.setAntiAlias(true);
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, mRadius-borderWidth, paint);

		super.onDraw(canvas);
	}

	private void setBackgroundCompat(int w, int h) {
		Bitmap bitmap = createShadowBitmap(w, h, mCornerRadius, borderWidth+5, mDx, mDy, borderColor);
		BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN) {
			setBackgroundDrawable(drawable);
		} else {
			setBackground(drawable);
		}
	}

	private Bitmap createShadowBitmap(int shadowWidth, int shadowHeight, float cornerRadius, float shadowRadius,
									  float dx, float dy, int shadowColor) {

		Bitmap output = Bitmap.createBitmap(shadowWidth, shadowHeight, Bitmap.Config.ALPHA_8);
		Canvas canvas = new Canvas(output);

		RectF shadowRect = new RectF(
				shadowRadius,
				shadowRadius,
				shadowWidth - shadowRadius,
				shadowHeight - shadowRadius);

		if (dy > 0) {
			shadowRect.top += dy;
			shadowRect.bottom -= dy;
		} else if (dy < 0) {
			shadowRect.top += Math.abs(dy);
			shadowRect.bottom -= Math.abs(dy);
		}

		if (dx > 0) {
			shadowRect.left += dx;
			shadowRect.right -= dx;
		} else if (dx < 0) {
			shadowRect.left += Math.abs(dx);
			shadowRect.right -= Math.abs(dx);
		}

		Paint shadowPaint = new Paint();
		shadowPaint.setAntiAlias(true);
		shadowPaint.setColor(shadowColor);
		shadowPaint.setStyle(Paint.Style.FILL);

		if (!isInEditMode()) {
			shadowPaint.setShadowLayer(shadowRadius, dx, dy, shadowColor);
		}

		canvas.drawRoundRect(shadowRect, cornerRadius, cornerRadius, shadowPaint);

		return output;
	}

	public void setCircleFillColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setBorderColor(int borderColor) {
		this.borderColor = borderColor;
	}
}

	