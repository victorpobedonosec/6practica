package com.example.practuhv3.repository

import androidx.lifecycle.LiveData
import com.example.practuhv3.activity.Post

interface PostRepository
{
    fun get(): LiveData<List<Post>>
    fun like(id: Long)
    fun share(id: Long)
}