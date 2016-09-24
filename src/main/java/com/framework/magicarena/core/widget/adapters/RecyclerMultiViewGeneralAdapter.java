package com.framework.magicarena.core.widget.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import com.framework.magicarena.core.collection.tuple.PairTuple;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Supply multi view template for RecyclerView Adapter.</p>
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
public abstract class RecyclerMultiViewGeneralAdapter<T> extends RecyclerSingleViewGeneralAdapter<T> implements DataSourceUpdateable<T> {
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
    private String mTypeField;
    private final List<String> mTypeValueList;
    private final List<Integer> mTypeLayoutList;

    //***************************************
    //*	Constructors						*
    //***************************************

    /**
     * Initializes a new instance of adapter for {@link android.support.v7.widget.RecyclerView}.
     *
     * @param context           context instance where {@link android.support.v7.widget.RecyclerView} is running on
     * @param data              initial data source for adapter,<code>null</code> may be allowed
     * @param layoutResIds      map for view type and layout resource id for layout of {@link android.support.v7.widget.RecyclerView}
     */
    public RecyclerMultiViewGeneralAdapter(Context context, List<T> data, PairTuple<String, Map<String, Integer>> layoutResIds) {
        super(context, data, 0);
        this.mTypeField = layoutResIds.getItem1();
        this.mTypeField = layoutResIds.getItem1();
        this.mTypeValueList = new ArrayList<>();
        this.mTypeLayoutList = new ArrayList<>();

        for (String type : layoutResIds.getItem2().keySet()) {
            this.mTypeValueList.add(type);
            this.mTypeLayoutList.add(layoutResIds.getItem2().get(type));
        }
    }

    //***************************************
    //*	Methods								*
    //***************************************
    //***********************************
    //*	Overrides Methods				*
    //***********************************
    @Override
    public int getItemViewType(int position) {
        try {
            T t = this.mData.get(position);
            Field field = t.getClass().getDeclaredField(this.mTypeField == null ? "type" : this.mTypeField);
            field.setAccessible(true);

            return this.mTypeValueList.indexOf(field.get(t).toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return IGNORE_ITEM_VIEW_TYPE;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType != IGNORE_ITEM_VIEW_TYPE) {
            View itemLayout = this.mInflater.inflate(this.mTypeLayoutList.get(viewType), parent, false);

            return new ViewHolder(itemLayout);
        } else {
            return null;
        }
    }
}