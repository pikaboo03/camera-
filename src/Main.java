import cameraModel.LensManager;
import cameraTextUI.CameraTextUI;

public class Main {
    public static void main(String[] arg){
        LensManager manager = new LensManager();
        CameraTextUI ui = new CameraTextUI(manager);
        ui.show();

    }
}
