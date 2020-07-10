package view;

public class ViewMain {
    public static void bootstrapView(){
        ViewCLI viewCLI = ViewCLI.createViewCli();
        viewCLI.initView();
    }
}
