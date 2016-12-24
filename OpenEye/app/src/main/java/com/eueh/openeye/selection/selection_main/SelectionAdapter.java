package com.eueh.openeye.selection.selection_main;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.selection.selection_detail.SelectionDetailActivity;
import com.eueh.openeye.selection.selectiontool.SelectionMyTool;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by 陈焕栋 on 16/12/20.
 */

public class SelectionAdapter extends BaseAdapter {
    //为了传值变成static
    private SelectionBean data;
    private Context context;


    private static final int TYPECOUNT = 50;
    private static final int TYPEVIDEO = 1;
    private static final int TYPETEXTFOOTER = 2;
    private static final int TYPEVIDEOCOLLECTIONWITHCOVER = 3;
    private static final int TYPETEXTHEADER = 4;
    private static final int TYPENEWELSE = 5;
    private static final int TYPEBANNER = 6;
    private static final int TYPEVIDEOCOLLECTIONOFFOLLOW = 7;
    private ViewHolderVideo holderVideo;


    public SelectionAdapter(Context context) {
        this.context = context;
    }

    public SelectionAdapter setData(SelectionBean data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getCount() {
        return data.getItemList().size();
    }

    @Override
    public Object getItem(int i) {
        return data.getItemList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        String typeVideo = "video";
        String typeTextFooter = "textFooter";
        String typeVideoCollectionWithCover = "videoCollectionWithCover";
        String typeTextHeader = "textHeader";
        String typeBanner = "banner";
        String typeVideoCollectionOfFollow = "videoCollectionOfFollow";

        if (data.getItemList().get(position).getType().equals(typeVideo)) {
            return TYPEVIDEO;
        } else if (data.getItemList().get(position).getType().equals(typeTextFooter)) {
            return TYPETEXTFOOTER;
        } else if (data.getItemList().get(position).getType().equals(typeVideoCollectionWithCover)) {
            return TYPEVIDEOCOLLECTIONWITHCOVER;
        } else if (data.getItemList().get(position).getType().equals(typeTextHeader)) {
            return TYPETEXTHEADER;
        } else if (data.getItemList().get(position).getType().equals(typeBanner)) {
            return TYPEBANNER;
        } else if (data.getItemList().get(position).getType().equals(typeVideoCollectionOfFollow)) {
            return TYPEVIDEOCOLLECTIONOFFOLLOW;
        } else {
            return TYPENEWELSE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPECOUNT;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        holderVideo = null;
        ViewHolderNewElse holderNewElse = null;
        ViewHolderTextFooter holderTextFooter = null;
        ViewHolderVideoCollectionWithCover holderVideoCollectionWithCover = null;
        ViewHolderTextHeader holderTextHeader = null;
        ViewHolderBanner holderBanner = null;
        ViewHolderVideoCollectionOfFollow holderVideoCollectionOfFollow = null;
        if (view == null) {
            switch (getItemViewType(i)) {
                case TYPEVIDEO:
                    view = LayoutInflater.from(context).inflate(R.layout.item_selection_fragment_video, viewGroup, false);
                    holderVideo = new ViewHolderVideo(view);
                    view.setTag(holderVideo);
                    break;
                case TYPETEXTFOOTER:
                    view = LayoutInflater.from(context).inflate(R.layout.item_selection_fragment_textfooter, viewGroup, false);
                    holderTextFooter = new ViewHolderTextFooter(view);
                    view.setTag(holderTextFooter);
                    break;
                case TYPEVIDEOCOLLECTIONWITHCOVER:
                    view = LayoutInflater.from(context).inflate(R.layout.item_selection_fragment_videocollectionwithcover, viewGroup, false);
                    holderVideoCollectionWithCover = new ViewHolderVideoCollectionWithCover(view);
                    view.setTag(holderVideoCollectionWithCover);
                    break;
                case TYPETEXTHEADER:
                    view = LayoutInflater.from(context).inflate(R.layout.item_selection_fragment_textheader, viewGroup, false);
                    holderTextHeader = new ViewHolderTextHeader(view);
                    view.setTag(holderTextHeader);
                    break;
                case TYPEBANNER:
                    view = LayoutInflater.from(context).inflate(R.layout.item_selection_fragment_banner, viewGroup, false);
                    holderBanner = new ViewHolderBanner(view);
                    view.setTag(holderBanner);
                    break;
                case TYPEVIDEOCOLLECTIONOFFOLLOW:
                    view = LayoutInflater.from(context).inflate(R.layout.item_selection_fragment_videocollectionoffollow, viewGroup, false);
                    holderVideoCollectionOfFollow = new ViewHolderVideoCollectionOfFollow(view);
                    view.setTag(holderVideoCollectionOfFollow);
                    break;
                case TYPENEWELSE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_selection_fragment_newelse, viewGroup, false);
                    holderNewElse = new ViewHolderNewElse(view);
                    view.setTag(holderNewElse);
                    break;
            }
        } else {
            switch (getItemViewType(i)) {
                case TYPEVIDEO:
                    holderVideo = (ViewHolderVideo) view.getTag();
                    break;
                case TYPETEXTFOOTER:
                    holderTextFooter = (ViewHolderTextFooter) view.getTag();
                    break;
                case TYPEVIDEOCOLLECTIONWITHCOVER:
                    holderVideoCollectionWithCover = (ViewHolderVideoCollectionWithCover) view.getTag();
                    break;
                case TYPETEXTHEADER:
                    holderTextHeader = (ViewHolderTextHeader) view.getTag();
                    break;
                case TYPEBANNER:
                    holderBanner = (ViewHolderBanner) view.getTag();
                    break;
                case TYPEVIDEOCOLLECTIONOFFOLLOW:
                    holderVideoCollectionOfFollow = (ViewHolderVideoCollectionOfFollow) view.getTag();
                    break;
                case TYPENEWELSE:
                    holderNewElse = (ViewHolderNewElse) view.getTag();
                    break;
            }
        }
        switch (getItemViewType(i)) {
            case TYPEVIDEO:
                //最常见的
                Glide.with(context).load(data.getItemList().get(i).getData().getCover().getFeed()).into(holderVideo.ivCover);
                holderVideo.tvTitle.setText(data.getItemList().get(i).getData().getTitle());
                holderVideo.tvCategory.setText("#" + data.getItemList().get(i).getData().getCategory() + "   /");
                Long titimi = (long) data.getItemList().get(i).getData().getReleaseTime()  ;
                holderVideo.tvReleaseTime.setText(SelectionMyTool.intoTime(titimi));

                //点击图片跳转到详情页
                //开了一个线程 设置动画
                holderVideo.ivCover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, SelectionDetailActivity.class);
////////////////////////把vp位置 传过去////////////////////////////////////
                    intent.putExtra("selection_viewpager_item_d" , i);
                    context.startActivity(intent);

                }
            });


                break;
            case TYPETEXTFOOTER:
                holderTextFooter.tvText.setText(data.getItemList().get(i).getData().getText());
                break;
            case TYPEVIDEOCOLLECTIONWITHCOVER:
                Glide.with(context).load(data.getItemList().get(i).getData().getHeader().getCover()).into(holderVideoCollectionWithCover.ivCover);


                SelectionVCWCRvAdapter myAdapter = new SelectionVCWCRvAdapter(context);
                List<SelectionBean.ItemListBeanX.DataBeanX.ItemListBean> list = data.getItemList().get(i).getData().getItemList();
                myAdapter.setData(list);
                holderVideoCollectionWithCover.rv.setAdapter(myAdapter);
                holderVideoCollectionWithCover.rv.setLayoutManager(
                        new LinearLayoutManager(context, 0, false));


                break;
            case TYPETEXTHEADER:
                holderTextHeader.tvText.setText(data.getItemList().get(i).getData().getText());
                break;
            case TYPEBANNER:
                Glide.with(context).load(data.getItemList().get(i).getData().getImage()).into(holderBanner.ivImage);
                break;
            case TYPEVIDEOCOLLECTIONOFFOLLOW:
                Glide.with(context).load(data.getItemList().get(i).getData().getHeader().getCover()).into(holderVideoCollectionOfFollow.ivCover);
                Glide.with(context).load(data.getItemList().get(i).getData().getHeader().getIconList().get(0))
                        .bitmapTransform(new CropCircleTransformation(context))
                        .into(holderVideoCollectionOfFollow.ivIconListLeft);
                Glide.with(context).load(data.getItemList().get(i).getData().getHeader().getIconList().get(1))
                        .bitmapTransform(new CropCircleTransformation(context))
                        .into(holderVideoCollectionOfFollow.ivIconListCenter);
                Glide.with(context).load(data.getItemList().get(i).getData().getHeader().getIconList().get(2))
                        .bitmapTransform(new CropCircleTransformation(context))
                        .into(holderVideoCollectionOfFollow.ivIconListRight);
                holderVideoCollectionOfFollow.tvTitle.setText(data.getItemList().get(i).getData().getHeader().getTitle());
                holderVideoCollectionOfFollow.tvDescription.setText(data.getItemList().get(i).getData().getHeader().getDescription());


                SelectionVCOFRvAdapter myAdapterVcof = new SelectionVCOFRvAdapter(context);
                List<SelectionBean.ItemListBeanX.DataBeanX.ItemListBean> listVcof = data.getItemList().get(i).getData().getItemList();
                myAdapterVcof.setData(listVcof);
                holderVideoCollectionOfFollow.rv.setAdapter(myAdapterVcof);
                holderVideoCollectionOfFollow.rv.setLayoutManager(new LinearLayoutManager(context, 0, false));

                break;
            case TYPENEWELSE:
                break;
        }
        return view;
    }
///////////////下面是自定义方法/////////////////////////////////////////////////////////////////////


///////////////下面是缓存类/////////////////////////////////////////////////////////////////////

    class ViewHolderVideo {
        private ImageView ivCover;
        private TextView tvTitle, tvCategory, tvReleaseTime;

        public ViewHolderVideo(View view) {
            ivCover = (ImageView) view.findViewById(R.id.iv_item_video_selection_cover_d);
            tvTitle = (TextView) view.findViewById(R.id.tv_item_video_selection_title_d);
            tvCategory = (TextView) view.findViewById(R.id.tv_item_video_selection_category_d);
            tvReleaseTime = (TextView) view.findViewById(R.id.tv_item_video_selection_releasetime_d);
        }
    }

    class ViewHolderTextFooter {
        private TextView tvText;

        public ViewHolderTextFooter(View view) {
            tvText = (TextView) view.findViewById(R.id.tv_item_textfooter_selection_text_d);
        }
    }

    class ViewHolderVideoCollectionWithCover {
        private ImageView ivCover;
        private RecyclerView rv;

        public ViewHolderVideoCollectionWithCover(View view) {
            ivCover = (ImageView) view.findViewById(R.id.iv_item_videocollectionwithcover_selection_cover_d);
            rv = (RecyclerView) view.findViewById(R.id.iv_item_videocollectionwithcover_selection_rv_d);
        }
    }

    class ViewHolderTextHeader {
        private TextView tvText;

        public ViewHolderTextHeader(View view) {
            tvText = (TextView) view.findViewById(R.id.tv_item_textheader_selection_text_d);
        }
    }

    class ViewHolderBanner {
        private ImageView ivImage;

        public ViewHolderBanner(View view) {
            ivImage = (ImageView) view.findViewById(R.id.iv_item_banner_selection_iamge_d);
        }
    }

    class ViewHolderVideoCollectionOfFollow {
        private ImageView ivCover, ivIconListLeft, ivIconListCenter, ivIconListRight;
        private TextView tvTitle, tvDescription;
        private RecyclerView rv;

        public ViewHolderVideoCollectionOfFollow(View view) {
            ivCover = (ImageView) view.findViewById(R.id.iv_item_videoCollectionOfFollow_selection_cover_d);
            ivIconListLeft = (ImageView) view.findViewById(R.id.iv_item_videoCollectionOfFollow_selection_iconList_left_d);
            ivIconListCenter = (ImageView) view.findViewById(R.id.iv_item_videoCollectionOfFollow_selection_iconList_center_d);
            ivIconListRight = (ImageView) view.findViewById(R.id.iv_item_videoCollectionOfFollow_selection_iconList_right_d);
            tvTitle = (TextView) view.findViewById(R.id.iv_item_videoCollectionOfFollow_selection_title_d);
            tvDescription = (TextView) view.findViewById(R.id.iv_item_videoCollectionOfFollow_selection_description_d);
            rv = (RecyclerView) view.findViewById(R.id.rv_item_vcof_selection_rv_d);
        }
    }

    class ViewHolderNewElse {
        public ViewHolderNewElse(View view) {
        }
    }


}
