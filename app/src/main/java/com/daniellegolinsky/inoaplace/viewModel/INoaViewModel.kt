package com.daniellegolinsky.inoaplace.viewModel

import androidx.lifecycle.ViewModel
import com.daniellegolinsky.inoaplace.model.INoaModel
import javax.inject.Inject

class INoaViewModel @Inject constructor(var model: INoaModel) : ViewModel() {

}