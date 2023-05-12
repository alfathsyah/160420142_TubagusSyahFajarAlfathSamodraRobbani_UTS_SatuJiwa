package com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420142_tubagussyahfajaralfathsamodrarobbani_uts_satujiwa.model.Comment
import com.example.adv160420142week4.R

class CommentAdapter(val commentList:ArrayList<Comment>) :RecyclerView.Adapter<CommentAdapter.CommentViewHolder>(){

    class CommentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.comment_list_item, parent, false)
        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val txtNama = holder.view.findViewById<TextView>(R.id.txtNamaDonatur)
        val txtkomen = holder.view.findViewById<TextView>(R.id.txtKomen)
        txtNama.text = commentList[position].name
        txtkomen.text = "Rp. " + commentList[position].komen
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateCommentList(newCommentList: Comment) {
        commentList.clear()
        commentList.addAll(listOf(newCommentList))
        notifyDataSetChanged()
    }
}