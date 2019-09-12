package com.lognote.listener

import com.lognote.modal.Category
import com.lognote.modal.LogNote

interface CatsClickListener {
    fun onClick(category: Category)
}