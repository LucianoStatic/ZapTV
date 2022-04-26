package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.myapp.zaptv.R
import com.myapp.zaptv.databinding.FragmentFavoriteBinding
import ui.viewmodel.FavoriteFragmentViewModel


class FavoriteFragment :BaseFragment<FragmentFavoriteBinding,FavoriteFragmentViewModel>() {
    override val viewModel: FavoriteFragmentViewModel
        get() = TODO("Not yet implemented")

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
            return FragmentFavoriteBinding.inflate(inflater,container,false)
    }


}