package com.example.pcs0834.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pcs0834.api.RetrofitClient
import com.example.pcs0834.data.User
import com.example.pcs0834.data.model.UserResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainViewModel : ViewModel() {
    val listUsers = MutableLiveData<ArrayList<User>>()

    fun setSearchUsers(query: String) {
        RetrofitClient.apiInstace
                .getSearchUsers(query)
                .enqueue(object : retrofit2.Callback<UserResponse>{
                    override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                        if (response.isSuccessful){
                            listUsers.postValue(response.body()?.items)
                        }
                    }

                    override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                        Log.d("Failure", t.message.toString())

                    }

                })

    }
    fun getSearchUsers () : LiveData<ArrayList<User>>{
        return listUsers
    }

}