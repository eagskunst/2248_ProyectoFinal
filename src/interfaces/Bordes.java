package interfaces;

import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public interface Bordes {
	SoftBevelBorder untouchedBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
	SoftBevelBorder touchedBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);
	EmptyBorder margin = new EmptyBorder(5, 20, 5, 20);
}
