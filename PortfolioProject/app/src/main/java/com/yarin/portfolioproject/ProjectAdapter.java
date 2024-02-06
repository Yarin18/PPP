package com.yarin.portfolioproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private final Project[] projects;

    public ProjectAdapter(final Project[] projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.bind(projects[position]);
    }

    @Override
    public int getItemCount() {
        return projects.length;
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {

        private ImageView appImage;
        private TextView appTitle, appDescription;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            this.appImage = itemView.findViewById(R.id.image_view_project_icon);
            this.appTitle = itemView.findViewById(R.id.textview_project_title);
            this.appDescription = itemView.findViewById(R.id.textview_project_description);
        }

        public void bind(final Project project) {
            appTitle.setText(project.getName());
            appDescription.setText(project.getDescription());
            appImage.setImageResource(project.getImage());
        }
    }

}
