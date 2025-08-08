package id.muf.data.repository.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.muf.domain.repository.Image.ImageLoader

class GlideImageLoader : ImageLoader {
    override fun loadImage(url: String, imageView: ImageView) {
        val requestOptions = RequestOptions()
            .placeholder(com.bumptech.glide.R.drawable.abc_item_background_holo_light) // placeholder saat gambar dimuat
            .error(com.bumptech.glide.R.drawable.abc_item_background_holo_dark) // gambar jika terjadi error

        Glide.with(imageView.context)
            .setDefaultRequestOptions(requestOptions)
            .load(url)
            .into(imageView)
    }
}