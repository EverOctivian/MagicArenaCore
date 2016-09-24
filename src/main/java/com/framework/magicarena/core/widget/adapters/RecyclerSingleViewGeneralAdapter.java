package com.framework.magicarena.core.widget.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Supply basic template for RecyclerView Adapter.</p>
 *
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
public abstract class RecyclerSingleViewGeneralAdapter<T> extends RecyclerView.Adapter<RecyclerSingleViewGeneralAdapter.ViewHolder> implements DataSourceUpdateable<T>, View.OnClickListener {
    //*******************************************
    //*	Static Area 							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private static final String TAG = AdapterSingleViewGeneralAdapter.class.getSimpleName();
    protected static final int IGNORE_ITEM_VIEW_TYPE = Adapter.IGNORE_ITEM_VIEW_TYPE;

    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    protected final List<T> mData;
    protected final LayoutInflater mInflater;
    protected final Context mContext;
    private final int mLayoutResId;
    private RecyclerView mRecyclerView;
    private OnItemViewClickedListener<T> mItemViewClickListener;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Initializes a new instance of adapter for {@link android.support.v7.widget.RecyclerView.Adapter}.
     *
     * @param context       context instance where {@link android.support.v7.widget.RecyclerView} is running on
     * @param data          initial data source for adapter,<code>null</code> may be allowed
     * @param layoutResId   resource id for layout of {@link android.support.v7.widget.RecyclerView}
     */
    public RecyclerSingleViewGeneralAdapter(Context context, List<T> data, int layoutResId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);

        if (data == null) {
            this.mData = new ArrayList<>();
        } else {
            this.mData = data;
        }

        this.mLayoutResId = layoutResId;
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Functional Methods				*
    //***********************************

    /**
     * Initialize views of {@link android.widget.AdapterView} then bind data.
     *
     * @param holder    an instance of {@link ViewHolder} that you can get sub views of {@link android.widget.AdapterView}
     * @param item      an item of data source
     */
    protected abstract void bindDataSource(ViewHolder holder, T item, int position);

    //***********************************
    //*	Abstract Methods				*
    //***********************************

    /**
     *  Set listener for receiving notification when a item view holder is clicked.
     *
     * @param onItemViewClickedListener specified listener when {@linkplain RecyclerView}'s item is clicked
     */
    protected final void setOnItemViewClickListener(OnItemViewClickedListener onItemViewClickedListener) {
        this.mItemViewClickListener = onItemViewClickedListener;
    }

    //***********************************
    //*	Implements Methods				*
    //***********************************
    @Override
    public void addDataSource(List<T> dataSource) {
        if (dataSource != null) {
            this.mData.addAll(dataSource);
            this.notifyDataSetChanged();

            Log.i(TAG, "addDataSource: " + dataSource.size() + " items has been successfully added!");
        } else {
            Log.e(TAG, "addDataSource: " + "data source may not be null!");
        }
    }

    @Override
    public void updateDataSouce(List<T> dataSource) {
        if (dataSource != null) {
            this.mData.clear();
            this.mData.addAll(dataSource);
            this.notifyDataSetChanged();

            Log.i(TAG, "updateDataSouce: " + dataSource.size() + " items has been successfully set!");
        } else {
            Log.e(TAG, "updateDataSouce: " + "data source may not be null!");
        }
    }

    @Override
    public void clearDataSource() {
        this.mData.clear();
    }


    //***********************************
    //*	Overrides Methods				*
    //***********************************
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        this.bindDataSource(holder, this.mData.get(position), position);

        holder.itemView.setOnClickListener(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = this.mInflater.inflate(this.mLayoutResId, parent, false);

        return new ViewHolder(itemLayout);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        this.mRecyclerView = recyclerView;
    }

    @Override
    public int getItemCount() {
        return this.mData != null ? this.mData.size() : 0;
    }

    @Override
    public void onClick(View v) {
        if (this.mItemViewClickListener != null) {
            int childAdapterPosition = this.mRecyclerView.getChildAdapterPosition(v);
            T itemData = this.mData.get(childAdapterPosition);
            this.mItemViewClickListener.onItemClicked(this.mRecyclerView, v, itemData, childAdapterPosition);
        }
    }

    //***********************************
    //*	Nested Classes  				*
    //***********************************

    /**
     * <p>A class that holds reffence of sub views of {@link android.support.v7.widget.RecyclerView.Adapter}.</p>
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
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static final String TYPE_ERROR_MESSAGE = "resource id %d must be an instance of %s";

        //*******************************************
        //*	Instance Area							*
        //*******************************************
        //***************************************
        //*	Fields								*
        //***************************************
        private View mConvertView;
        private Map<Integer, View> mCacheViewMap;

        //***************************************
        //*	Constructors						*
        //***************************************
        public ViewHolder(View viewItem) {
            super(viewItem);
            this.mConvertView = viewItem;
            this.mCacheViewMap = new HashMap<>();
        }

        //***************************************
        //*	Methods								*
        //***************************************
        //***********************************
        //*	Functional Methods				*
        //***********************************

        /**
         * Get reference of specified view in {@link android.widget.AdapterView}。
         *
         * @param viewResId resource id of specified view
         * @param <R>       type of specified view
         * @return sub view with specified type
         */
        public <R> R getView(final int viewResId) {
            View view = null;

            if (this.mCacheViewMap.containsKey(viewResId)) {
                view = this.mCacheViewMap.get(viewResId);
            } else {
                view = this.mConvertView.findViewById(viewResId);
                this.mCacheViewMap.put(viewResId, view);
            }

            return (R) view;
        }

        /**
         * Set text of {@link TextView} with specified resource id.
         *
         * @param resID resource id of {@link TextView} or its subclass
         * @param text  specified content that's gonna be set
         */
        public void setViewText(int resID, CharSequence text) {
            View view = this.getView(resID);

            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            } else {
                throw new IllegalArgumentException(String.format(TYPE_ERROR_MESSAGE, resID, "TextView"));
            }
        }

        /**
         * Set image source of {@link ImageView} with specified resource id with URL string.
         *
         * @param resID resource id of {@link ImageView} or its subclass
         * @param url  specified URL that's represented for some external image resource
         */
        public void setViewImage(int resID, String url) {
            View view = this.getView(resID);

            if (view instanceof ImageView) {
                x.image().bind((ImageView) view, url);
            } else {
                throw new IllegalArgumentException(String.format(TYPE_ERROR_MESSAGE, resID, "ImageView"));
            }
        }

        /**
         * Set image source of {@link ImageView} with specified resource id with URL string.
         *
         * @param resID         resource id of {@link ImageView} or its subclass
         * @param url           specified URL that's represented for some external image resource
         * @param imageOptions  options when displaying image into imageview
         */
        public void setViewImage(int resID, String url, ImageOptions imageOptions) {
            View view = this.getView(resID);

            if (view instanceof ImageView) {
                x.image().bind((ImageView) view, url, imageOptions);
            } else {
                throw new IllegalArgumentException(String.format(TYPE_ERROR_MESSAGE, resID, "ImageView"));
            }
        }

        /**
         * Set checked status of {@link CompoundButton} with specified resource id.
         *
         * @param resID      resource id of {@link CompoundButton} or its subclass
         * @param isChecked  checked status that's switched to
         */
        public void setViewChecked(int resID, boolean isChecked) {
            View view = this.getView(resID);

            if (view instanceof CheckBox) {
                ((CheckBox) view).setChecked(isChecked);
            } else {
                throw new IllegalArgumentException(String.format(TYPE_ERROR_MESSAGE, resID, "CheckBox"));
            }
        }
    }

    /**
     * <p>Interface for receiving notification when a item view is clicked. </p>
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
    public interface OnItemViewClickedListener<T> {
        /**
         * Response action when receiving notification when a item view is clicked.
         *
         * @param parentView adapter that event is from
         * @param itemView   view of selected item
         * @param item       bound data of selected item
         * @param position   position of selected item
         */
        void onItemClicked(RecyclerView parentView, View itemView, T item, int position);
    }
}
