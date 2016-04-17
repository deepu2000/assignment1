package com.org.dot.github.apitest;


import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryBranch;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.RepositoryTag;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.RepositoryService;

/**
 * Print a user's repositories
 */
public class ReadRepo {

	/**
	 * Prints a user's repositories
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final String user = "deepu2000";
		final String format = "{0}) {1}   - created on {2}";
		int count = 1;
		System.out.println("Time Pass");
		RepositoryId repoID = RepositoryId.createFromUrl("https://github.com/ruby/ruby");
		RepositoryService service = new RepositoryService();
		ContentsService contService = new ContentsService();
 		Repository ruby = service.getRepository(repoID);
		System.out.println(MessageFormat.format(format, count++,
				ruby.getName(), ruby.getCreatedAt()));
		
		
		
		for (RepositoryBranch  repo : service.getBranches(repoID)){
			List<RepositoryContents> content = contService.getContents(repoID, null, repo.getName());
			System.out.println(content.toString());
			System.out.println(MessageFormat.format(format, count++,
					repo.getName(), repo.toString()));
		}
		
		
		System.out.println("List of Tags :");
		
		for (RepositoryTag repo : service.getTags(repoID)){
			
			System.out.println(MessageFormat.format(format, count++,
					repo.getName(), repo.toString()));
			
		}
			
	}
}
