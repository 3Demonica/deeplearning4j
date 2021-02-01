/*
 *  ******************************************************************************
 *  *
 *  *
 *  * This program and the accompanying materials are made available under the
 *  * terms of the Apache License, Version 2.0 which is available at
 *  * https://www.apache.org/licenses/LICENSE-2.0.
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  * License for the specific language governing permissions and limitations
 *  * under the License.
 *  *
 *  * SPDX-License-Identifier: Apache-2.0
 *  *****************************************************************************
 */

package org.deeplearning4j.spark.api;

import org.deeplearning4j.nn.api.Model;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.MultiDataSet;

import java.io.Serializable;

/**
 * A hook for the workers when training.
 * A pre update and post update method are specified
 * for when certain information needs to be collected
 * or there needs to be specific parameters
 * or models sent to remote locations for visualization
 * or other things.
 *
 * @author Adam Gibson
 */
public interface TrainingHook extends Serializable {
    /**
     * A hook method for pre update.
     * @param minibatch the inibatch
     *                  that was used for the update
     * @param model themodel that was update
     */
    void preUpdate(DataSet minibatch, Model model);

    /**
     * A hook method for post update
     * @param minibatch the minibatch
     *                  that was usd for the update
     * @param model the model that was updated
     */
    void postUpdate(DataSet minibatch, Model model);

    /**
     * A hook method for pre update.
     * @param minibatch the inibatch
     *                  that was used for the update
     * @param model the model that was update
     */
    void preUpdate(MultiDataSet minibatch, Model model);

    /**
     * A hook method for post update
     * @param minibatch the minibatch
     *                  that was usd for the update
     * @param model the model that was updated
     */
    void postUpdate(MultiDataSet minibatch, Model model);

}
