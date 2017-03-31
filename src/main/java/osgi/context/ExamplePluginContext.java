package osgi.context;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.dscsag.plm.spi.interfaces.gui.PluginContext;
import com.dscsag.plm.spi.interfaces.gui.PluginRequest;

public class ExamplePluginContext implements PluginContext
{
  private JPanel panel;
  private JLabel label;

  public ExamplePluginContext()
  {
    panel = new JPanel(new BorderLayout());
    label = new JLabel("Hello world");
    panel.add(label, BorderLayout.CENTER);
  }

  @Override
  public String getContextKey()
  {
    return "ctx_org_dogoodthings_example2";
  }

  @Override
  public Container getDisplay()
  {
    return panel;
  }

  @Override
  public void dataReceived(PluginRequest data)
  {
    SwingUtilities.invokeLater(() -> {
      label.setText(data.getObjects().stream().map(x -> x.getType() + "@" + x.getKey())
          .collect(Collectors.joining(" - ", "Dropped from ECTR objects:", "")));
    });
  }

}