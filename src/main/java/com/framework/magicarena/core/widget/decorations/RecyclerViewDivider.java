package com.framework.magicarena.core.widget.decorations;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <p>Supply basic template for Adapter.</p>
 *
 * </br>
 * <b>Maintenance History</b>:
 * <table>
 * 		<tr>
 * 			<th>Date</th>
 * 			<th>Developer</th>
 * 			<th>Target</th>
 * 			<th>Content</th>
 * 		</tr>
 * 		<tr>
 * 			<td>2016-8-17</td>
 * 			<td>Guo QingJun</td>
 * 			<td>All</td>
 *			<td>Created.</td>
 * 		</tr>
 * </table>
 */
public class RecyclerViewDivider extends RecyclerView.ItemDecoration {
    //*******************************************
    //*	Instance Area 							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private Paint mPaint;
    private Drawable mDivider;
    private int mDividerHeight = 2;
    private int mOrientation;
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    //***************************************
    //*	Constructor							*
    //***************************************

    /**
     * Initializes a new instance of {@link RecyclerViewDivider}.
     *
     * @param context       a {@link Context} of the application package implementing this class
     * @param orientation   orientation that the divider lies in
     */
    public RecyclerViewDivider(Context context, int orientation) {
        if (orientation != LinearLayoutManager.VERTICAL && orientation != LinearLayoutManager.HORIZONTAL) {
            throw new IllegalArgumentException("wrong orientation of divider:only LinearLayoutManager.HORIZONTAL or LinearLayoutManager.VERTICAL will be allowed.");
        }

        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        this.mOrientation = orientation;
        this.mDivider = a.getDrawable(0);
        a.recycle();
    }

    /**
     * Initializes a new instance of {@link RecyclerViewDivider}.
     *
     * @param context       a {@link Context} of the application package implementing this class
     * @param orientation   orientation that the divider lies in
     * @param drawableId    the {@link Drawable} that divider is drawn with
     */
    public RecyclerViewDivider(Context context, int orientation, int drawableId) {
        this(context, orientation);
        this.mDivider = ContextCompat.getDrawable(context, drawableId);
        this.mDividerHeight = mDivider.getIntrinsicHeight();
    }

    /**
     * Initializes a new instance of {@link RecyclerViewDivider}.
     *
     * @param context       a {@link Context} of the application package implementing this class
     * @param orientation   orientation that the divider lies in
     * @param dividerHeight the {@link Drawable} that divider is drawn with
     * @param dividerColor  the color that divider is drawn with
     */
    public RecyclerViewDivider(Context context, int orientation, int dividerHeight, int dividerColor) {
        this(context, orientation);
        this.mDividerHeight = dividerHeight;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(dividerColor);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************

    /**
     * Draw horizontal divider with specified configuration.
     *
     * @param canvas    the canvas where paint draws the divider
     * @param parent    the parent control where the divider's drawn
     */
    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + layoutParams.bottomMargin;
            final int bottom = top + this.mDividerHeight;
            if (this.mDivider != null) {
                this.mDivider.setBounds(left, top, right, bottom);
                this.mDivider.draw(canvas);
            }
            if (this.mPaint != null) {
                canvas.drawRect(left, top, right, bottom, this.mPaint);
            }
        }
    }

    /**
     * Draw vertical divider with specified configuration.
     *
     * @param canvas    the canvas where paint draws the divider
     * @param parent    the parent control where the divider's drawn
     */
    private void drawVertical(Canvas canvas, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layoutParams.rightMargin;
            final int right = left + this.mDividerHeight;
            if (this.mDivider != null) {
                this.mDivider.setBounds(left, top, right, bottom);
                this.mDivider.draw(canvas);
            }
            if (this.mPaint != null) {
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    //***********************************
    //*	Overrides Methods				*
    //***********************************
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, this.mDividerHeight);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        if (this.mOrientation == LinearLayoutManager.VERTICAL) {
            this.drawVertical(c, parent);
        } else {
            this.drawHorizontal(c, parent);
        }
    }
}
