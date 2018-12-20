package osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.dscsag.plm.spi.interfaces.gui.PluginContext;

import osgi.context.MagicEyesPluginContext;

/**
 * Activator to register provided services
 */
public class Activator implements BundleActivator
{

  @Override
  public void start(BundleContext context) throws Exception
  {
    // then register our service, which "enhances" the ECTR file handling
    context.registerService(PluginContext.class, new MagicEyesPluginContext(), null);
  }

  @Override
  public void stop(BundleContext context) throws Exception
  {
    // empty
  }

}