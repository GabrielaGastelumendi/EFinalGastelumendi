package com.gabriela.efinal.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.gabriela.efinal.model.ShowEntity;

import java.util.List;

public class DogRespository {
    private DogDao dao;
    private DogDatabase db;

    public DogRespository(Application application){
        db = DogDatabase.getInstance(application);
        dao = db.dogDao();
    }

    public void addShow(ShowEntity showEntity){
        DogDatabase.dataBaseWriteExecutor.execute(() ->
                dao.addShow(showEntity));
    }

    public LiveData<List<ShowEntity>> getAll(){
        return dao.getAll();
    }
}


