package com.example.myapplication.data.remote.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myapplication.data.remote.apiservices.CharacterApiService
import com.example.myapplication.data.remote.model.Character
import retrofit2.HttpException
import java.io.IOException

private const val CHARACTER_START_PAGE_INDEX = 1

//class CharacterPagingSources(
//    private val services: CharacterApiService
//) : PagingSource<Int, Character>() {

//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
//        val position = params.key ?: CHARACTER_START_PAGE_INDEX
//
//        return try {
//            val response = services.fetchCharacters(position)
//            val next = if (response.info.next == null) {
//                null
//            } else {
//                Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
//            }
//
//            LoadResult.Page(
//                data = response.results,
//                prevKey = null,
//                nextKey = next
//            )
//        }catch (exception:IOException){
//            LoadResult.Error(exception)
//        }catch (exception:HttpException){
//            LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage.prevKey?.plus(1)?: anchorPage?.nextKey.minus(1)
//        }
//    }
//}