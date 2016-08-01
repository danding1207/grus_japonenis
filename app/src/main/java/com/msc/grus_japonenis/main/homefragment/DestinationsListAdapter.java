package com.msc.grus_japonenis.main.homefragment;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.databinding.DestinationsListItemHeaderBinding;
import com.msc.grus_japonenis.databinding.DestinationsListItemNormalBinding;
import com.msc.grus_japonenis.databinding.DestinationsListItemTitleBinding;
import com.msc.grus_japonenis.databinding.PublishListItemAddBinding;
import com.msc.lib.net.bean.Adverts;
import com.msc.lib.net.bean.Destinations;
import com.msc.lib.net.listener.OnTapListener;
import com.msc.lib.utils.UnitConversionUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msc on 2016/3/29.
 */
public class DestinationsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int HEADERVIEWHOLDER = 0010;
    public static final int TITLEVIEWHOLDER = 0011;
    public static final int NORMALVIEWHOLDER = 0012;

    private static Activity context;
    private static HomeFragmentPresenter homeFragmentPresenter;
    private Destinations destinations;
    private Adverts adverts;
    private static List<String> advertslist = new ArrayList<>();
    private static List<Destinations.DataEntity.DestinationsEntity> list = new ArrayList<>();
    private static OnTapListener onTapListener;
    private static int width;
    private static int height;
    private static int h;

    public DestinationsListAdapter(Activity context, HomeFragmentPresenter homeFragmentPresenter) {
        this.context = context;
        this.homeFragmentPresenter = homeFragmentPresenter;
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels;     // 屏幕宽度（像素）
        height = (int) (width * 378f / 808f);   // 屏幕高度（像素）
        h = (int) ((width - UnitConversionUtils.dipTopx(context, 12 * 4)) / 3f);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADERVIEWHOLDER;
        } else {
            if (list != null && list.size() > 0) {
                if (TextUtils.isEmpty(list.get(3 * (position - 1)).getTitle())) {
                    return NORMALVIEWHOLDER;
                } else {
                    return TITLEVIEWHOLDER;
                }
            }
            return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case HEADERVIEWHOLDER:
                DestinationsListItemHeaderBinding destinationsListItemHeaderBinding = DestinationsListItemHeaderBinding.inflate(inflater, parent, false);
                return new HeaderViewHolder(destinationsListItemHeaderBinding);
            case TITLEVIEWHOLDER:
                DestinationsListItemTitleBinding destinationsListItemTitleBinding = DestinationsListItemTitleBinding.inflate(inflater, parent, false);
                return new TitleViewHolder(destinationsListItemTitleBinding);
            case NORMALVIEWHOLDER:
                DestinationsListItemNormalBinding destinationsListItemNormalBinding = DestinationsListItemNormalBinding.inflate(inflater, parent, false);
                return new NormalViewHolder(destinationsListItemNormalBinding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) (holder)).bind(adverts);
        } else if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) (holder)).bind(position - 1);
        } else if (holder instanceof NormalViewHolder) {
            ((NormalViewHolder) (holder)).bind(position - 1);
        }

    }

    @Override
    public int getItemCount() {
        return list == null || list.size() == 0 ? 1 : list.size() / 3 + 1;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public DestinationsListItemHeaderBinding destinationsListItemHeaderBinding;

        public HeaderViewHolder(DestinationsListItemHeaderBinding destinationsListItemHeaderBinding) {
            super(destinationsListItemHeaderBinding.getRoot());
            this.destinationsListItemHeaderBinding = destinationsListItemHeaderBinding;
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(width, height);
            params.bottomMargin = 24;
//            params.topMargin = UnitConversionUtils.dipTopx(context, 96);
            destinationsListItemHeaderBinding.convenientBanner.setLayoutParams(params);

        }

        public void bind(Adverts adverts) {
            if (adverts != null) {
                destinationsListItemHeaderBinding.convenientBanner.setPages(
                        new CBViewHolderCreator<NetworkImageHolderView>() {
                            @Override
                            public NetworkImageHolderView createHolder() {
                                return new NetworkImageHolderView();
                            }
                        }, advertslist)
                        //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                        .setPageIndicator(new int[]{R.drawable.dot_while, R.drawable.dot_green})
                        //设置指示器的方向
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
//                .setOnPageChangeListener(this)//监听翻页事件
                        .setOnItemClickListener(homeFragmentPresenter);
                homeFragmentPresenter.setConvenientBanner(destinationsListItemHeaderBinding.convenientBanner);
                destinationsListItemHeaderBinding.convenientBanner.stopTurning();
                destinationsListItemHeaderBinding.convenientBanner.startTurning(3000);
            }

        }
    }

    public static class TitleViewHolder extends RecyclerView.ViewHolder {

        public DestinationsListItemTitleBinding destinationsListItemTitleBinding;

        public TitleViewHolder(DestinationsListItemTitleBinding destinationsListItemTitleBinding) {
            super(destinationsListItemTitleBinding.getRoot());
            this.destinationsListItemTitleBinding = destinationsListItemTitleBinding;

            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(h, h);
            destinationsListItemTitleBinding.ivDestinations1.setLayoutParams(params1);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(h, h);
            params2.leftMargin = UnitConversionUtils.dipTopx(context, 12);
            params2.rightMargin = UnitConversionUtils.dipTopx(context, 12);
            destinationsListItemTitleBinding.ivDestinations2.setLayoutParams(params2);

            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(h, h);
            destinationsListItemTitleBinding.ivDestinations3.setLayoutParams(params3);

        }

        public void bind(int position) {
            destinationsListItemTitleBinding.setPresenter(homeFragmentPresenter);
            destinationsListItemTitleBinding.setArray(new Destinations.DataEntity.DestinationsEntity[]{list.get(3 * position), list.get(3 * position + 1), list.get(3 * position + 2)});
        }
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder {

        public DestinationsListItemNormalBinding destinationsListItemNormalBinding;

        public NormalViewHolder(DestinationsListItemNormalBinding destinationsListItemNormalBinding) {
            super(destinationsListItemNormalBinding.getRoot());

            this.destinationsListItemNormalBinding = destinationsListItemNormalBinding;

            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(h, h);
            destinationsListItemNormalBinding.ivDestinations1.setLayoutParams(params1);

            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(h, h);
            params2.leftMargin = UnitConversionUtils.dipTopx(context, 12);
            params2.rightMargin = UnitConversionUtils.dipTopx(context, 12);
            destinationsListItemNormalBinding.ivDestinations2.setLayoutParams(params2);

            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(h, h);
            destinationsListItemNormalBinding.ivDestinations3.setLayoutParams(params3);
        }

        public void bind(int position) {
            destinationsListItemNormalBinding.setPresenter(homeFragmentPresenter);
            destinationsListItemNormalBinding.setArray(new Destinations.DataEntity.DestinationsEntity[]{list.get(3 * position), list.get(3 * position + 1), list.get(3 * position + 2)});
        }
    }


    public void setOnTapListener(OnTapListener onTapListener) {
        this.onTapListener = onTapListener;
    }


    public Destinations getDestinations() {
        return destinations;
    }

    public void setDestinations(Destinations destinations) {
        this.destinations = destinations;
        initDestinations();
        notifyDataSetChanged();
    }

    private void initDestinations() {
        list.clear();
        for (Destinations.DataEntity data : destinations.getData()) {
            for (int i = 0; i < data.getDestinations().size(); i++) {
                Destinations.DataEntity.DestinationsEntity des = data.getDestinations().get(i);
                if (i == 0) {
                    des.setTitle(data.getName());
                }
                list.add(des);
            }
        }
    }

    public Adverts getAdverts() {
        return adverts;
    }

    public void setAdverts(Adverts adverts) {
        this.adverts = adverts;
        advertslist = new ArrayList<>();
        for (Adverts.DataEntity advert : adverts.getData()) {
            advertslist.add(advert.getPhoto().getPhoto_url());
        }
        notifyItemChanged(0);
    }

    public static OnTapListener getOnTapListener() {
        return onTapListener;
    }


    public static class NetworkImageHolderView implements Holder<String> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            //你可以通过layout文件来创建，也可以像我一样用代码创建，不一定是Image，任何控件都可以进行翻页
            imageView = new ImageView(context);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            Glide
                    .with(context)
                    .load(data)
                    .centerCrop()
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.advertisement_placeholder)
                    .crossFade()
                    .into(imageView);
        }
    }

}
