package id.muf.presentation.adapter.user

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.muf.data.repository.image.GlideImageLoader
import id.muf.domain.model.user.list.ListUserItem
import id.muf.domain.model.user.local.ListUserLocal
import id.muf.presentation.R
import id.muf.presentation.databinding.ListUserBinding
import id.muf.presentation.ui.user.detail.DetailUserActivity

class ListUserAdapter(val activity: Activity, var listItemUser: ArrayList<ListUserLocal>): RecyclerView.Adapter<ListUserAdapter.ViewHolder>() {
    var binding: ListUserBinding? = null
    var imageLoader: GlideImageLoader? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.list_user, parent, false)
        imageLoader = GlideImageLoader()
        return ViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.listsUserBinding.txtUsername.text = listItemUser[position].username
        holder.listsUserBinding.cvUser.setOnClickListener {
            DetailUserActivity.launchIntent(activity, listItemUser[position].username)
        }
        imageLoader?.loadImage(listItemUser[position].avatarUrl.toString(), holder.listsUserBinding.ivUser)
    }

    override fun getItemCount(): Int {
        return listItemUser.size
    }

    class ViewHolder(listUserBinding: ListUserBinding) : RecyclerView.ViewHolder(listUserBinding.getRoot()) {
        var listsUserBinding: ListUserBinding
        init {
            listsUserBinding = listUserBinding
        }
    }

    //==============================================Edit Text Filter=============================================================
    //fungsi filter pada adapter recyclerView
    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filterdNames: ArrayList<ListUserLocal>) {
        this.listItemUser = filterdNames
        notifyDataSetChanged()
    }
    //===========================================================================================================================

}