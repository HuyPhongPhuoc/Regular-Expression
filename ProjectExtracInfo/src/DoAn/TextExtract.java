package DoAn;

public class TextExtract 
{
	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Text Extract :" + this.text;
	}
	
	
}
