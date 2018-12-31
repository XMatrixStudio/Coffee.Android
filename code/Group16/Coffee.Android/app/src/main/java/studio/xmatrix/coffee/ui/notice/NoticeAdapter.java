package studio.xmatrix.coffee.ui.notice;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import studio.xmatrix.coffee.R;
import studio.xmatrix.coffee.databinding.NoticeItemBinding;
import studio.xmatrix.coffee.ui.detail.DetailActivity;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {
    private FragmentActivity activity;

    public NoticeAdapter(FragmentActivity activity) {
        this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.notice_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final NoticeItemBinding binding;

        ViewHolder(NoticeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind() {
            if (badge == null) {
                badge = new QBadgeView(activity)
                    .bindTarget(binding.noticeRemove)
                    .setBadgeGravity(Gravity.CENTER)
                    .setBadgeText("New");
            }
            binding.noticeLayout.setOnClickListener(v -> {
                activity.startActivity(new Intent(activity, DetailActivity.class));
            });
            badge.setOnDragStateChangedListener((dragState, badge, targetView) -> {
                // todo
            });
            // badge.hide(true);
            // binding.setModel(i);
        }
    }
}
