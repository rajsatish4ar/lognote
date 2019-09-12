package com.lognote.listener

import com.lognote.modal.LogNote

interface LogClickListener {
    fun onClick(log: LogNote)
}