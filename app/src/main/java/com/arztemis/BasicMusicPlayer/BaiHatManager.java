package com.arztemis.BasicMusicPlayer;

public class BaiHatManager {
    private static BaiHatManager instance;

    private BaiHatManager() {
        //for singleton
    }

    public static BaiHatManager getInstance() {
        if (instance == null) {
            instance = new BaiHatManager();
        }
        return instance;
    }

    public void getAllBH(OnActionCallBack callBack) {
        MTask task = new MTask(null, new MTask.OnMTaskCallBack() {
            @Override
            public Object execTask(String key, Object data, MTask task) {
                return App.getInstance().getDB().getBaiHatDAO().getListBH();
            }

            @Override
            public void completeTask(String key, Object data) {
                callBack.callBack(data);
            }
        });
        task.start(null);
    }
}
