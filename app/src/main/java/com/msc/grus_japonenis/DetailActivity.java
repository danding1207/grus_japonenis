package com.msc.grus_japonenis;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.databinding.ActivityDetailBinding;
import com.msc.grus_japonenis.databinding.DestinationsListItemNormalBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;

public class DetailActivity extends BaseActivity {

//    @Inject
//    MainPresenter mPresenter;
//    @Inject
//    MainViewModel mViewModel;

    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = DataBindingUtil.setContentView(this, setContentViewIds());
//        activityMainBinding.setMainViewModel(mViewModel);
//        mPresenter.attachView(this);
        initView();
    }

    @Override
    public int setContentViewIds() {
        return R.layout.activity_detail;
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {
//        DaggerMainActivityComponent.builder()
//                .applicationComponent(appComponent)
//                .mainActivityModule(new MainActivityModule(this))
//                .build()
//                .inject(this);
    }

    public void initView() {
        colorChange(this, ContextCompat.getColor(this, R.color.appToolbarColor));
        activityDetailBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityDetailBinding.recyclerView.setAdapter(new MyAdapater());
//        setSupportActionBar(activityDetailBinding.collapsingToolbarLayout);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    class MyAdapater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            DestinationsListItemNormalBinding destinationsListItemNormalBinding = DestinationsListItemNormalBinding.inflate(inflater, parent, false);
            return new NormalViewHolder(destinationsListItemNormalBinding);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class NormalViewHolder extends RecyclerView.ViewHolder {

            public DestinationsListItemNormalBinding destinationsListItemNormalBinding;

            public NormalViewHolder(DestinationsListItemNormalBinding destinationsListItemNormalBinding) {
                super(destinationsListItemNormalBinding.getRoot());
                this.destinationsListItemNormalBinding = destinationsListItemNormalBinding;
            }
        }

    }


}
