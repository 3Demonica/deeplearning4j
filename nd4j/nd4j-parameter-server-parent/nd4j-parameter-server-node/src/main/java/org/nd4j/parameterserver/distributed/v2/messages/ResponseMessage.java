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

package org.nd4j.parameterserver.distributed.v2.messages;

public interface ResponseMessage extends VoidMessage {

    /**
     * This message returns request id, used to join request and response
     * @return
     */
    String getRequestId();

    /**
     * This method allows to set request id
     * PLEASE NOTE: This method must be used only from Transport context
     *
     * @param requestId
     */
    void setRequestId(String requestId);
}
