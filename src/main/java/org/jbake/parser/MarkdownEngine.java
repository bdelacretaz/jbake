package org.jbake.parser;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.Extension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * Renders documents in the Markdown format.
 *
 * @author Cédric Champeau
 */
public class MarkdownEngine extends MarkupEngine {

    @Override
    public void processBody(final ParserContext context) {
        String[] mdExts = context.getConfig().getStringArray("markdown.extensions");
        List<Extension> extensions = new ArrayList<>();
        
        if (mdExts.length > 0) {
            for (int index = 0; index < mdExts.length; index++) {
                String ext = mdExts[index];
                if (ext.startsWith("-")) {
		    ext = ext.substring(1);
                    // TODO extensions=removeExtension(extensions, extensionFor(ext));
                } else {
                    if (ext.startsWith("+")) {
		      ext = ext.substring(1);
                    }
                    // TODO extensions=addExtension(extensions, extensionFor(ext));
                }
            }
        }
        
        Parser parser = Parser.builder().build();
        Node document = parser.parse(context.getBody());
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        context.setBody(renderer.render(document).trim());
    }

    private Extension extensionFor(String name) {
        Extension result = null;
        
        if (name.equals("HARDWRAPS")) {
            // TODO
        } else if (name.equals("AUTOLINKS")) {
            // TODO
        } else if (name.equals("FENCED_CODE_BLOCKS")) {
            // TODO
        } else if (name.equals("DEFINITIONS")) {
            // TODO
        } else if (name.equals("ABBREVIATIONS")) {
            // TODO
        } else if (name.equals("QUOTES")) {
            // TODO
        } else if (name.equals("SMARTS")) {
            // TODO
        } else if (name.equals("SMARTYPANTS")) {
            // TODO
        } else if (name.equals("SUPPRESS_ALL_HTML")) {
            // TODO
        } else if (name.equals("SUPPRESS_HTML_BLOCKS")) {
            // TODO
        } else if (name.equals("SUPPRESS_INLINE_HTML")) {
            // TODO
        } else if (name.equals("TABLES")) {
            // TODO
        } else if (name.equals("WIKILINKS")) {
            // TODO
        } else if (name.equals("ANCHORLINKS")) {
            // TODO
        } else if (name.equals("STRIKETHROUGH")) {
            // TODO
        }else if (name.equals("ATXHEADERSPACE")) {
            // TODO
        }else if (name.equals("FORCELISTITEMPARA")) {
            // TODO
        }else if (name.equals("RELAXEDHRULES")) {
            // TODO
        }else if (name.equals("TASKLISTITEMS")) {
            // TODO
        }else if (name.equals("EXTANCHORLINKS")) {
            // TODO
        } else if (name.equals("ALL")) {
            // TODO
        } else if (name.equals("ALL_OPTIONALS")) {
            // TODO
        } else if (name.equals("ALL_WITH_OPTIONALS")) {
            // TODO
        }
        return result;
    }
    private int addExtension(int previousExtensions, int additionalExtension) {
    	return previousExtensions | additionalExtension;
    }
    private int removeExtension(int previousExtensions, int unwantedExtension) {
    	return previousExtensions & (~unwantedExtension);
    }

}
