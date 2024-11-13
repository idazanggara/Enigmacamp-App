package com.example.enigmacampapp.presentation.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmacampapp.R

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private var contactName = arrayOf(
        "Idaz Anggara",
        "Lara McEwan",
        "Victor Mancini",
        "Mira Holt",
        "Diana Firdaus",
        "Marco Cavalli",
        "Sophia Aranda",
        "James O'Reilly",
        "Natalie Benitez",
        "Carlos Estevez",
        "Emily Dawson"
    )

    private var contactJob = arrayOf(
        "Android Developer",
        "Backend Developer",
        "Frontend Developer",
        "QA Engineer",
        "Android Developer",
        "Android Developer",
        "Project Manager",
        "UI/UX Designer",
        "Data Analyst",
        "DevOps Engineer",
        "Product Manager"
    )

    private var contactImage = intArrayOf(
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact,
        R.drawable.ic_account_circle_contact
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.itemContactName.text = contactName[position]
        holder.itemContactJob.text = contactJob[position]
        holder.itemContactImage.setImageResource(contactImage[position])
    }

    override fun getItemCount(): Int = contactName.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemContactImage: ImageView = itemView.findViewById(R.id.contact_image)
        var itemContactName: TextView = itemView.findViewById(R.id.tv_contact_name)
        var itemContactJob: TextView = itemView.findViewById(R.id.tv_contact_job)

        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked on ${contactName[position]}", Toast.LENGTH_LONG).show()
            }
        }
    }
}