/*
 * CC BY-SA 4.0
 *
 * The code is licensed with "Attribution-ShareAlike 4.0 International license".
 * See the license details:
 *     https://creativecommons.org/licenses/by-sa/4.0/
 *
 * Copyright (C) 2017 Vladimír Ulman
 */
package org.mastodon.ctc;

import net.imagej.ImageJ;
import org.mastodon.mamut.MainWindow;
import org.mastodon.mamut.WindowManager;
import org.mastodon.mamut.project.MamutProject;

import javax.swing.*;
import java.io.File;
import java.util.Locale;

public class testMastodonPlugins
{
	public static void main( final String[] args ) throws Exception
	{
		//start up our own Fiji/Imagej2
		final ImageJ ij = new net.imagej.ImageJ();
		ij.ui().showUI();

		Locale.setDefault( Locale.US );
		UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );

		//final MamutProject project = new MamutProject( null, new File( "x=1000 y=1000 z=100 sx=1 sy=1 sz=10 t=400.dummy" ) );
		final MamutProject project = new MamutProject(
				new File( "/home/ulman/data/Polyclad/2019-09-06_EcNr2_NLSH2B-GFP_T-OpenSPIM_singleTP.mastodon" ),
				new File( "/home/ulman/data/Polyclad/2019-09-06_EcNr2_NLSH2B-GFP_T-OpenSPIM_singleTP.xml" ) );

		//start up own Mastodon window
		final WindowManager wm = new WindowManager( ij.getContext() );
		wm.getProjectManager().open( project );
		new MainWindow( wm ).setVisible( true );
	}
}
