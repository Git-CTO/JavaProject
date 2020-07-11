package view;

public class ViewMain {
    private ViewMain() {
    }

    public static void bootstrapView() {
        ViewCLI viewCLI = ViewCLI.createViewCli();
        viewCLI.initView();
    }
}
