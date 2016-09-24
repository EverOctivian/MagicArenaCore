package com.framework.magicarena.core.widget.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public abstract class AdapterSingleViewGeneralAdapter<T> extends BaseAdapter implements DataSourceUpdateable<T> {
    //*******************************************
    //*	Static Area 							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    private static final String TAG = AdapterSingleViewGeneralAdapter.class.getSimpleName();

    //*******************************************
    //*	Instance Area							*
    //*******************************************
    //***************************************
    //*	Fields								*
    //***************************************
    protected final List<T> mData;
    protected final LayoutInflater mInflater;
    private final int mLayoutResId;
    protected Context mContext;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Initializes a new instance of adapter for {@link android.widget.AdapterView}.
     *
     * @param context       context instance where {@link android.widget.AdapterView} is running on
     * @param data          initial data source for adapter,<code>null</code> may be allowed
     * @param layoutResId   resource id for layout of {@link android.widget.AdapterView}
     */
    public AdapterSingleViewGeneralAdapter(Context context, List<T> data, int layoutResId) {
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

    public void addDataSource(List<T> dataSource) {
        if (dataSource != null) {
            this.mData.addAll(dataSource);
            this.notifyDataSetChanged();

            Log.i(TAG, "addDataSource: " + dataSource.size() + " items has been successfully added!");
        } else {
            Log.e(TAG, "addDataSource: " + "data source may not be null!");
        }
    }

    public void updateDataSouce(List<T> dataSource) {
        if (dataSource != null) {
            this.mData.clear();
            this.mData.addAll(dataSource);
            this.notifyDataSetChanged();

            Log.i(TAG, "setDataSource: " + dataSource.size() + " items has been successfully set!");
        } else {
            Log.e(TAG, "setDataSource: " + "data source may not be null!");
        }
    }

    public void clearDataSource() {
        this.mData.clear();
        this.notifyDataSetChanged();

        Log.i(TAG, "clearDataSource: " + "data source has been successfully cleared!");
    }

    //***********************************
    //*	Overrides Methods				*
    //***********************************
    @Override
    public int getCount() {
        return this.mData != null ? this.mData.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return this.mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = this.mInflater.inflate(this.mLayoutResId, null);

            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        this.bindDataSource(holder, this.getItem(position), position);

        return convertView;
    }

    //***********************************
    //*	Nested Classes  				*
    //***********************************

    /**
     * <p>A class that holds reffence of sub views of {@link android.widget.AdapterView}.</p>
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
    public class ViewHolder {
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
        public ViewHolder(View convertView) {
            this.mConvertView = convertView;
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
}