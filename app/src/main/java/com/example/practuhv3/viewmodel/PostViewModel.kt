package com.example.practuhv3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.practuhv3.activity.Post
import com.example.practuhv3.repository.PostRepository
import com.example.practuhv3.repository.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data: LiveData<List<Post>> = repository.get()

    fun like(id:Long) = repository.like(id)
    fun share(id:Long) = repository.share(id)
}