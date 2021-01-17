package com.example.pcs0834.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pcs0834.api.RetrofitClient
import com.example.pcs0834.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel:ViewModel() {
    val listFollowers = MutableLiveData<ArrayList<User>>()
    fun  setListFollowers(username:String){
        RetrofitClient.apiInstace
            .getFollowers(username)
            .enqueue(object :Callback<ArrayList<User>>{
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
                    if (response.isSuccessful){
                        listFollowers.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    Log.d("Failure",t.message.toString())
                }

            })

    }
    fun getListFollowers(): LiveData<ArrayList<User>>{
        return listFollowers
    }
}