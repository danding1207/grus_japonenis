/*
 * Copyright 2015 Andrea De Cesare
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.msc.grus_japonenis.publish;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.databinding.PublishListItemAddBinding;
import com.msc.grus_japonenis.databinding.PublishListItemNormalBinding;
import com.msc.lib.net.listener.ItemStatusListener;
import com.msc.lib.net.listener.ItemTouchListener;
import com.msc.lib.utils.UnitConversionUtils;

import java.util.ArrayList;
import java.util.Collections;

public class PublishPicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchListener {

    public static final int ADDVIEWHOLDER = 0011;
    public static final int NORMALVIEWHOLDER = 0012;
    private Activity activity;
    private ArrayList<Uri> mSelectedPic;
    private static int width;
    private static int height;
    private static int h;
    private PublishPresenter mPresenter;

    public PublishPicAdapter(Activity activity, ArrayList<Uri> mSelectedPic, PublishPresenter mPresenter) {
        this.activity = activity;
        this.mSelectedPic = mSelectedPic;
        this.mPresenter = mPresenter;
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels;     // 屏幕宽度（像素）
        height = (int) (width * 378f / 808f);   // 屏幕高度（像素）
        h = (int) ((width - UnitConversionUtils.dip2px(activity, 12 * 4)) / 3f);
    }

    public void updata(ArrayList<Uri> mSelectedPic) {
        this.mSelectedPic = mSelectedPic;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if((mSelectedPic==null || mSelectedPic.size()<9) && position==getItemCount()-1) {
            return ADDVIEWHOLDER;
        } else {
            return NORMALVIEWHOLDER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ADDVIEWHOLDER:
                PublishListItemAddBinding publishListItemAddBinding = PublishListItemAddBinding.inflate(inflater, parent, false);
                return new AddViewHolder(publishListItemAddBinding);
            case NORMALVIEWHOLDER:
                PublishListItemNormalBinding publishListItemNormalBinding = PublishListItemNormalBinding.inflate(inflater, parent, false);
                return new NormalViewHolder(publishListItemNormalBinding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AddViewHolder) {
            ((AddViewHolder) (holder)).bind(position);
        } else if (holder instanceof NormalViewHolder) {
            ((NormalViewHolder) (holder)).bind(position);
        }
    }

    @Override
    public int getItemCount() {
        return mSelectedPic == null ? 1 : (mSelectedPic.size() < 9 ? mSelectedPic.size() + 1 : 9);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if(mSelectedPic!=null && fromPosition<mSelectedPic.size() && toPosition<mSelectedPic.size()) {
            Collections.swap(mSelectedPic, fromPosition, toPosition);
            notifyItemMoved(fromPosition, toPosition);
            notifyItemChanged(fromPosition);
            notifyItemChanged(toPosition);
        }
    }

    @Override
    public void onItemDismiss(int position) {
        mSelectedPic.remove(position);
        notifyItemRemoved(position);
    }

    public class AddViewHolder extends RecyclerView.ViewHolder implements ItemStatusListener {

        public PublishListItemAddBinding publishListItemAddBinding;

        public AddViewHolder(PublishListItemAddBinding publishListItemAddBinding) {
            super(publishListItemAddBinding.getRoot());
            this.publishListItemAddBinding = publishListItemAddBinding;
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(h, h);
            publishListItemAddBinding.getRoot().setLayoutParams(params);
        }

        public void bind(int position) {
            publishListItemAddBinding.setPresenter(mPresenter);
        }

        @Override
        public void onItemSelected() {
        }

        @Override
        public void onItemClear() {
        }
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder implements ItemStatusListener {

        public PublishListItemNormalBinding publishListItemNormalBinding;

        public NormalViewHolder(PublishListItemNormalBinding publishListItemNormalBinding) {
            super(publishListItemNormalBinding.getRoot());
            this.publishListItemNormalBinding = publishListItemNormalBinding;
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(h, h);
            publishListItemNormalBinding.getRoot().setLayoutParams(params);
        }

        public void bind(int position) {
            publishListItemNormalBinding.setUri(mSelectedPic.get(position));
            if(position==0) {
                publishListItemNormalBinding.setIsCover(true);
            } else {
                publishListItemNormalBinding.setIsCover(false);
            }
        }

        @Override
        public void onItemSelected() {
        }

        @Override
        public void onItemClear() {
        }
    }

}
